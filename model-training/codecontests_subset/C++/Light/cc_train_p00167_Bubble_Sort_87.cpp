#include<iostream>
using namespace std;
int n,ans,tmp;
int t[100];
int main(){
  while(cin>>n&&n){
    for(int i=0;i<n;i++)cin>>t[i];
    ans=0;
    for(int i=n-1;i>0;i--){
      for(int j=0;j<i;j++){
	if(t[j]>t[j+1]){
	  tmp=t[j];t[j]=t[j+1];t[j+1]=tmp;
	  ans++;
	}
      }
    }
    cout<<ans<<endl;
  }
  return 0;
}