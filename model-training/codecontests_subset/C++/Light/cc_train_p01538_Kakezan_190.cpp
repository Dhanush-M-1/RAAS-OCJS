#include<iostream>
using namespace std;

int main(){
  int q,r,a;
  cin>>q;

  for(int i=0;i<q;i++){
    cin>>r;
    int j=10,count=1;
    a=r;

    while(1){
      a/=j;
      if(a==0)break;
      count++;
    }
    int count1=0;
    while(1){
      int max=0;
      j=10; 
      if(r/j==0)break;
      
      for(int k=1;k<count;k++){
	a=(r/j)*(r%j);
	if(max<a)max=a;
	j*=10;
      }

      r=max;
      count1++;
    }

    cout<<count1<<endl;
  }

  return 0;
}