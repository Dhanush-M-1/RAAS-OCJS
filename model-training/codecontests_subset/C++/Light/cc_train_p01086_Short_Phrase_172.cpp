#include<bits/stdc++.h>

#define REP(i,s,n) for(int i=s;i<n;++i)
#define rep(i,n) REP(i,0,n)

using namespace std;

int n;
string w[50];
int limit[] = {5,7,5,7,7};

int main() {
  while( cin >> n, n ) {
    rep(i,n) cin >> w[i];
    rep(i,n) {
      int index = 0;
      int sum = 0;
      REP(j,i,n) {
	sum += (int)w[j].size();
	if( sum == limit[index] ) {
	  ++index;
	  sum = 0;
	  if( index >= 5 ) {
	    cout << i+1 << endl;
	    goto Fin;
	  }
	} else if( sum > limit[index] ) {
	  break;
	}
      }
    }
    Fin:;
  }
  return 0;
}