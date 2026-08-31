#include <iostream>
#include <string>
using namespace std;

int main(){
  int a,sum,k,l,sta,suc,h[50],han[5]={5,7,5,7,7};
  string s;
  while(cin>>a){
    if(a==0)break;
    for(int i=0;i<a;i++){
      cin>>s;
      h[i]=s.size();
    }
    suc=0;
    for(int i=0;i<a;i++){
      sum=0;k=0;l=0;
      while(1){
	sum+=h[i+k];
	  if(sum==han[l]){
	    l++;
	    sum=0;
	  }else if(sum>han[l])break;
	if(l==5){
	  suc=1;
	  break;
	}
	k++;
	if(k>=a)break;
      }
      if(suc==1){
	sta=i;
	break;
      }
    }
    cout<<sta+1<<endl;
  }
  return 0;
}