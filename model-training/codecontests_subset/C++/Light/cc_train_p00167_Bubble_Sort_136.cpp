#include<iostream>
#include<algorithm>
using namespace std;

int main(){
  int i,n,num[1000001];
  while(1){
  cin >> n;
  if(n==0)break;
  for(i = 0; i < 1000001; i++){
    num[i]=0;
  }
  
  for(i = 0;i < n; i++){
    cin >> num[i];
  }
  
  int cnt=0;

  for(i = 0; i < n; i++){
    for(int j = 0; j < n-1; j++){
      if(num[j] > num[j+1]){
	cnt++;
	swap(num[j],num[j+1]);
      }
    }
  }
  cout << cnt << endl;
  }
  return 0;
}