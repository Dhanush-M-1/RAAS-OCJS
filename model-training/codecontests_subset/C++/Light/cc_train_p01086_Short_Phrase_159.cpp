#include <iostream>
#include <string>
using namespace std;

int main(){
  string w;
  int len[40];
  int tanku[]={5,7,5,7,7};
  int n,sum=0;
  for(;;){
    cin>>n;
    if(n==0) break;
    for(int i=0;i<n;i++){
      cin>>w;
      len[i]=w.size();
      sum+=len[i];
    }
    for(int i=0,jud=0;i<n;i++){
      if(sum<27) break;
      for(int j=i,k=0,m=0;j<n;j++){
	if(m+len[j]>tanku[k]) break;
	else if(m+len[j]==tanku[k]){
	  k++; m=0;
	}
	else m+=len[j];
	if(k==5){
	  cout<<i+1<<endl; jud=1; break;
	}
      }
      if(jud) break;
    }
  }
}
