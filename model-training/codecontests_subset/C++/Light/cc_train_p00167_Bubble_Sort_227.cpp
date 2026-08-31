//16
#include<iostream>
#include<algorithm>

using namespace std;

int main(){
  for(int n;cin>>n,n;){
    int a[100];
    for(int i=0;i<n;i++){
      cin>>a[i];
    }
    int ans=0;
    bool up;
    do{
      up=false;
      for(int i=0;i<n-1;i++){
	if(a[i]>a[i+1]){
	  ans++;
	  up=true;
	  swap(a[i],a[i+1]);
	}
      }
    }while(up);
    cout<<ans<<endl;
  }
  return 0;
}