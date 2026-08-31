#include <bits/stdc++.h>
#define REP(i, a, n) for(ll i = ((ll) a); i < ((ll) n); i++)
using namespace std;
typedef long long ll;
typedef pair< ll, vector<ll> > state;

int main(void) {
  ll N;
  while(cin >> N, N) {
    vector<ll> schedule(N, 0);
    REP(i, 0, N) REP(j, 0, 16) {
      ll d;
      cin >> d;
      schedule[i] = schedule[i] | (d << (15 - j));
    }

    set<state> st;
    st.insert(state(5, vector<ll>({ 0xffff, 0xffff, 0xffff, 0xffff, 0xffff, 0xffff })));

    ll ans = 0;

    REP(i, 0, N) {
      set<state> nst;

      for(state s : st) {
        ll p = s.first;
        vector<ll> past = s.second;

        ll rain[16] = {
          0x3300, 0x6600, 0xcc00, 0x0000,
          0x0330, 0x0660, 0x0cc0, 0x0000,
          0x0033, 0x0066, 0x00cc, 0x0000,
          0x0000, 0x0000, 0x0000, 0x0000
        };
        ll r = rain[p];

        ll u = schedule[i] & r;
        ll t = r;
        REP(j, 0, 6) t = t | past[j];

        if(u == 0 && t == 0xffff) {
          if(i + 1 == N) ans = 1;

          vector<ll> current(6);
          current[0] = r;
          REP(j, 0, 5) current[j + 1] = past[j];

          ll y = p / 4, x = p % 4;
          REP(dy, -2, 3) REP(dx, -2, 3) if(dy == 0 || dx == 0) {
            ll ny = y + dy, nx = x + dx;
            if(0 <= ny && ny < 3 && 0 <= nx && nx < 3) {
              ll np = ny * 4 + nx;
              nst.insert(state(np, current));
            }
          }
        }
      }

      swap(st, nst);
    }

    cout << ans << endl;
  }
}
