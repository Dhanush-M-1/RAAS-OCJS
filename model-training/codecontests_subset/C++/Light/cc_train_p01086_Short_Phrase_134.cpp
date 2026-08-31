#include<bits/stdc++.h>
using namespace std;

int main(){
  int n;
  const int haiku[5]={5,7,5,7,7};
  while(cin>>n,n){
    vector<string> w(n);
    for(int i=0;i<n;i++) cin>>w[i];
    int res=-1;
    for(int i=0;i<n && res==-1;i++){
      int stage=0;
      int cnt=0;
      for(int j=i;j<n;j++){
	cnt+=w[j].size();
	if(cnt==haiku[stage]){
	  stage++;
	  cnt=0;
	}
	if(stage==5){
	  res=i+1;
	  break;
	}

      }
    }
    cout<<res<<endl;
  }
  return 0;
}