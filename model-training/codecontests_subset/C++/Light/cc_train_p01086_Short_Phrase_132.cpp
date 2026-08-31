#include <bits/stdc++.h>
using namespace std;

#define max(a,b) ((a)>(b)?(a):(b))
#define min(a,b) ((a)<(b)?(a):(b))

typedef long long LL;

int main(){
  int n;
  string s;
  int len[5]={5,7,5,7,7};
  int count;
  int now;
  int ans;
  while(1){
    cin >> n;
    if(n==0) return 0;
    vector<int> w(n);
    for(int i=0;i<n;i++){
      cin >> s;
      w[i]=s.length();
    }
    ans=-1;
    for(int i=0;i<n;i++){
      count=0;
      now=0;
      for(int j=i;j<n;j++){
        count+=w[j];
        if(count==len[now]){
          now++;
          count=0;
          if(now==5){
            ans=i;
          }
        }else if(count>len[now]){
          break;
        }
      }
      if(ans!=-1){
        break;
      }
    }
    cout << ans+1 << endl;
  }
  return 0;
}

