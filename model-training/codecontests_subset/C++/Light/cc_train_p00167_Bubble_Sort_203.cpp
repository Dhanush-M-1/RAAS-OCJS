#include <iostream>
#include <algorithm>
using namespace std;

int bubblesort(int arr[], int n){
  int cnt = 0;
  for(int i = n - 1; i > 0; i--){
    for(int j = 0; j < i; j++){
      if(arr[j] > arr[j+1]){
        swap(arr[j], arr[j+1]);
        cnt++;
      }
    }
  }
  return cnt;
}

int main(void){
  int n;
  while(cin >> n, n != 0){
    int *arr = new int[n];
    for(int i = 0; i < n; i++){
      cin >> arr[i];
    }
    int cnt = bubblesort(arr, n);
    cout << cnt << endl;
  }
  return 0;
}