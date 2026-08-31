#include <bits/stdc++.h>
#define FOR(i,a,b) for(int i=(a);i<(b);i++)
#define REP(i,n) FOR(i,0,n)

using namespace std;

int check[]={5,7,5,7,7};

int main(){
  int n;
  while(cin >> n, n){
    vector<string> s(n);
    for(int i=0;i<n;i++)
      cin >> s[i];
    int ans=0;
    for(int f=0;f<n;f++){
      int p=f;
      bool ok=true;
      for(int k=0;k<5;k++){
	int nowl=0;
	while(nowl<check[k]){
	  nowl+=s[p].size();
	  p++;
	} 
	if(nowl!=check[k])
	  ok=false;
      }
      if(ok){
	ans=f+1;
	break;
      }
    }
    cout << ans << endl;
  }
  return 0;
}