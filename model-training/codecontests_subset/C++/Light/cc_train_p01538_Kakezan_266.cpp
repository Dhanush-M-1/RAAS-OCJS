#include<iostream>
#include<cmath>
#include<algorithm>
using namespace std;

int step(int n){
  int digit=1,tmp;
  tmp=n;
  int res=0;
  while((tmp=tmp / 10)>0)digit++;
  for(int i=1;i<digit;i++){
    int first,latter;
    first=n/(int)pow(10,i);
    latter=n%(int)pow(10,i);
    res=max(res,first*latter);
  }
  return res;
}

int main(){
  int q,n;
  cin>>q;
  for(int i=0;i<q;i++){
    int ans=0,prev=n;
    cin>>n;
    while(n>9){
      prev=n;
      n=step(n);
      if(n==prev){
	cout << -1 << endl;
	break;
      }
      ans++;
    }
    cout << ans << endl;
  }
  return 0;
}