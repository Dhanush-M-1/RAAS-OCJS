#include <iostream>
#define REP(i, a, n) for(int i = a; i <= n; i++)
using namespace std;

int N, len[41];
int p[6] = { 0, 5, 7, 5, 7, 7 };

bool check(int s) {
  // cout << s << endl;
  REP(i, 1, 5) {
    int d = 0;
    while(s <= N) {
      d += len[s++];
      // cout << "  " << s << " " << i << " " << d << endl;
      if(d > p[i]) return false;
      if(d == p[i]) break;
    }
    if(d < p[i]) return false;
  }
  return true;
}

int main(void) {
  while(cin >> N, N) {
    REP(i, 1, N) {
      string S; cin >> S;
      len[i] = S.length();
    }

    REP(i, 1, N) {
      if(!check(i)) continue;
      cout << i << endl;
      goto CONTINUE;
    }

CONTINUE: continue;
  }

  return 0;
}