#include<iostream>

using namespace std;

int main(){

  int n;

  while(cin >> n){
    if(n == 0) break;

    int data[n];
    int sum = 0;

    for(int i = 0; i < n; i++){
      cin >> data[i];
    }
    int tmp;
    for(int j = 0; j < n; j++){
      for(int i = 0; i < n-1-j; i++){
	if(data[i] > data[i+1]){
	  tmp = data[i];
	  data[i] = data[i+1];
	  data[i+1] = tmp;
	  sum++;
	}
      }
    }

    cout << sum << endl;
  }
  return 0;
}
    