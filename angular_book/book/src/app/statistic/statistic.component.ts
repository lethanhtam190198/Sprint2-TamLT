import {Component, OnInit} from '@angular/core';
import {StatisticService} from '../service/statistic.service';
import {FormControl, FormGroup} from '@angular/forms';
import {Chart, registerables} from 'chart.js';
import {Books} from '../model/books';

@Component({
  selector: 'app-statistic',
  templateUrl: './statistic.component.html',
  styleUrls: ['./statistic.component.css']
})
export class StatisticComponent implements OnInit {

  statistic: Books[] = [];
  myChart: any = {};
  startDate: any;
  endDate: any;

  form: FormGroup = new FormGroup({
    startDate: new FormControl(),
    endDate: new FormControl()
  });

  constructor(private statisticService: StatisticService) {
    Chart.register(...registerables);
  }

  getStatistic() {
    this.statisticService.getListSellingTop10(this.startDate, this.endDate).subscribe(value => {
      this.statistic = value;
      console.log(value);
      const label = [];
      const data = [];
      for (let i = 0; i < this.statistic.length; i++) {
        label[i] = this.statistic[i].name;
        data[i] = this.statistic[i].sumQuantity;
      }
      this.myChart.destroy();
      this.myChart = new Chart('myChart', {
        type: 'bar',
        data: {
          labels: label,
          datasets: [{
            label: 'Số lượng mua',
            data,
            backgroundColor: [
              'rgba(255, 99, 132, 0.2)',
              'rgba(54, 162, 235, 0.2)',
              // 'rgba(255, 206, 86, 0.2)',
              // 'rgba(75, 192, 192, 0.2)',
              // 'rgba(153, 102, 255, 0.2)',
              // 'rgba(255, 159, 64, 0.2)'
            ],
            borderColor: [
              'rgba(255, 99, 132, 1)',
              'rgba(54, 162, 235, 1)',
              // 'rgba(255, 206, 86, 1)',
              // 'rgba(75, 192, 192, 1)',
              // 'rgba(153, 102, 255, 1)',
              // 'rgba(255, 159, 64, 1)'
            ],
            borderWidth: 1
          }]
        },
        options: {
          scales: {
            y: {
              beginAtZero: true
            }
          }
        }
      });
    });
  }

  ngOnInit(): void {
    this.myChart = new Chart('myChart', {
      type: 'bar',
      data: {
        labels: ['', '', '', '', '', ''],
        datasets: [{
          label: 'Số lượng mua',
          data: [0, 0, 0, 0, 0, 0],
          backgroundColor: [
            'rgba(255, 99, 132, 0.2)',
            'rgba(54, 162, 235, 0.2)',
            'rgba(255, 206, 86, 0.2)',
            'rgba(75, 192, 192, 0.2)',
            'rgba(153, 102, 255, 0.2)',
            'rgba(255, 159, 64, 0.2)'
          ],
          borderColor: [
            'rgba(255, 99, 132, 1)',
            'rgba(54, 162, 235, 1)',
            'rgba(255, 206, 86, 1)',
            'rgba(75, 192, 192, 1)',
            'rgba(153, 102, 255, 1)',
            'rgba(255, 159, 64, 1)'
          ],
          borderWidth: 1
        }]
      },
      options: {
        scales: {
          y: {
            beginAtZero: true
          }
        }
      }
    });
  }

  submitForm() {
    this.startDate = this.form.value.startDate;
    this.endDate = this.form.value.endDate;
    this.getStatistic();

  }
}
