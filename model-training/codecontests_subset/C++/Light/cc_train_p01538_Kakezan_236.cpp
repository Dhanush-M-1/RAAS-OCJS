#include <bits/stdc++.h>
typedef long long LL;
#define SORT(c) sort((c).begin(),(c).end())

#define FOR(i,a,b) for(int i=(a);i<(b);++i)
#define REP(i,n)  FOR(i,0,n)

using namespace std;
int main(void)
{
  int q;
  cin >> q;
  REP(i,q){
    int n;
    cin >> n;
    int answer=0;
    while(n>=10){
      ++answer;
      int tmp=0;
      for(int d=10;d<n;d*=10)
	tmp=max(tmp,(n/d)*(n%d));
      n=tmp;
    }
    cout << answer << endl;
  }
  return 0;
}