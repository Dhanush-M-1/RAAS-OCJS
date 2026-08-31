#include<bits/stdc++.h>
using namespace std;

int main()
{
  int n;
  int cnt[50];
  int moji[5]={5,7,5,7,7};
  
  while(1){
    cin >> n;
    if(n==0) break;
    for(int i=0;i < n;i++){
      string str;
      cin >> str;
      cnt[i]=str.size();
    }
    
    int ans=-1;
    for(int i=0;i<n;i++){
      if(ans!=-1)continue;
      int now=0;
      int len=0;
      for(int j=i;j < n;j++){
	len+=cnt[j];
	if(len == moji[now]){
	  now++;
	  len=0;
	}else if(len > moji[now]){
	  break;
	}
	if(now==5){
	  ans=i;
	  break;
	}
      }
    }
    cout << ans+1 << endl;
  }
  return 0;
}
