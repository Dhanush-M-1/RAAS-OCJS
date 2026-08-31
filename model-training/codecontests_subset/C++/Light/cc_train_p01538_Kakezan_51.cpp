#include<iostream>
using namespace std;
int main(){
  int n;
  cin>>n;
  for(int i=0;i<n;i++){
    int num,cnt=0;
    cin>>num;
    while(1){
      int max=0;
      if(num/10==0)break;
      for(int j=10;num/j>0;j*=10){
        int a=num/j,b=num%j;
        if(a*b>max)max=a*b;
      }
      num=max;
      cnt++;
    }
    cout<<cnt<<endl;
  }
  return 0;
}