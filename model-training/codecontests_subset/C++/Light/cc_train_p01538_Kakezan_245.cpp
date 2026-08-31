// 2424_Kakezan.cpp
// 途中
#include <bits/stdc++.h>
using namespace std;

int solve(int n, int cnt){
  if(n<10) return cnt;

  int m=-1;
  for(int i=10;n/i>0;i*=10)
    m=max(m, (n/i)*(n%i));

  cnt++;
  return solve(m,cnt);
}
int main() {
  int q,n;
  cin>>q;

  for(int i=0;i<q;++i) {
    cin>>n;
    cout<<solve(n,0)<<endl;
  }

  return 0;
}

