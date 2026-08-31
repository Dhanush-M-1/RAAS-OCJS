#include <bits/stdc++.h>
typedef long long LL;
#define SORT(c) sort((c).begin(),(c).end())

#define FOR(i,a,b) for(int i=(a);i<(b);++i)
#define REP(i,n)  FOR(i,0,n)

using namespace std;
int main(void)
{
  for(;;){
    int n;
    cin >> n;
    if(!n) return 0;
    vector<string> p(n);
    REP(i,n) cin >> p[i];
    REP(i,n){
      int tmp=0,count=0;
      FOR(j,i,n){
	tmp+=p[j].size();
	if(tmp==5||tmp==12||tmp==17||tmp==24||tmp==31) ++count;
	if(tmp>=31) break;
      }
      if(count==5){
	cout << i+1 << endl;
	break;
      }
    }
  }
}