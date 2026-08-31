// g++ -std=c++17 -O3 -fmax-errors=1 -fsanitize=undefined
#include <bits/stdc++.h>

using namespace std;

#define fst first
#define snd second
#define all(c) ((c).begin()), ((c).end())
#define TEST(s) if (!(s)) { cout << __LINE__ << " " << #s << endl; exit(-1); }

// state =  x : x == n % mod
struct ModuloAutomaton {
  int mod;
  ModuloAutomaton(int mod) : mod(mod) { }
  int init() { return 0; }
  int size() { return mod; }
  int next(int state, int a) { return (10 * state + a) % mod; }
  bool accept(int state) { return state == 0; }
};
// state =  0        : empty
//          1        : fail
//          2 ... 10 : singleton and last number is state-1
//         11 ... 19 : increased and last number is state-10
//         20 ... 28 : decreased and last number is state-20
struct ZigZagAutomaton {
  int init() { return 0; }
  int size() { return 29; }
  int next(int state, int a) {
    if (state == 0) return a == 0 ? 0 : a + 1;
    if (state == 1) return 1; 
    if (state <= 10) {
      int last = state - 1;
      if      (a > last) return a + 10;
      else if (a < last) return a + 20;
    } else if (state <= 19) {
      int last = state - 10;
      if (a < last) return a + 20;
    } else if (state <= 28) {
      int last = state - 20;
      if (a > last) return a + 10;
    }
    return 1;
  }
  bool accept(int state) { return state != 1; }
};

template <class Automaton1, class Automaton2>
struct CompositionAutomaton {
  Automaton1 A;
  Automaton2 B;
  int created = 0;
  vector<vector<int>> table;
  vector<int> fst, snd;
  int compose(int state1, int state2) {
    if (table[state1][state2] < 0) {
      table[state1][state2] = fst.size();
      fst.push_back(state1);
      snd.push_back(state2);
    }
    return table[state1][state2];
  }
  CompositionAutomaton(Automaton1 A, Automaton2 B) : A(A), B(B) { 
    table.assign(A.size(), vector<int>(B.size(), -1));
  }
  int init() { return compose(A.init(), B.init()); }
  int size() { return A.size() * B.size(); }
  int next(int state, int a) {
    return compose(A.next(fst[state], a), B.next(snd[state], a));
  }
  bool accept(int state) {
    return A.accept(fst[state]) && B.accept(snd[state]);
  }
};
template <class Automaton>
int digitDP(string num, Automaton A, int eq = 1) {
  int n = num.size();
  vector<vector<vector<int>>> dp(n+1);

  dp[0] = vector<vector<int>>(2, vector<int>(A.size()));
  dp[0][1][A.init()] = 1;
  auto addTo = [&](int &x, int y) {
    if ((x += y) >= 10000) x -= 10000;
  };
  for (int i = 0; i < n; ++i) {
    //cout << i << endl;
    dp[i+1] = vector<vector<int>>(2, vector<int>(A.size()));
    for (int tight = 0; tight <= 1; ++tight) {
      for (int state = 0; state < A.size(); ++state) {
        if (dp[i][tight][state] == 0) continue;
        int lim = (tight ? num[i] - '0' : 9);
        for (int d = 0; d <= lim; ++d) {
          int tight_ = tight && d == lim;
          int state_ = A.next(state, d);
          addTo(dp[i+1][tight_][state_], dp[i][tight][state]);
        }
      }
    }
    dp[i].clear();
  }
  int ans = 0;
  for (int tight = 0; tight <= eq; ++tight) 
    for (int state = 0; state < A.size(); ++state) 
      if (A.accept(state)) addTo(ans, dp[n][tight][state]);
  return ans;
}

template <class Automaton>
int debug(string num, Automaton A) {
  function<void(int,int,int,string)> rec 
    = [&](int i, int tight, int state, string s) {
    if (i == num.size()) {
      if (A.accept(state)) cout << s << endl;
      return;
    }
    int lim = (tight ? num[i] - '0' : 9);
    for (int d = 0; d <= lim; ++d) {
      int tight_ = tight && d == lim;
      int state_ = A.next(state, d);
      s.push_back('0' + d);
      rec(i+1, tight_, state_, s);
      s.pop_back();
    }
  };
  rec(0, 1, A.init(), "");
}

int main() {
  char A[1000], B[1000];
  int M;
  scanf("%s %s %d", A, B, &M);
  ZigZagAutomaton zigzag;
  ModuloAutomaton modulo(M);
  CompositionAutomaton<ZigZagAutomaton,ModuloAutomaton> CM(zigzag, modulo);
  int a = digitDP(A, CM, 0);
  int b = digitDP(B, CM, 1);
  cout << (b + (10000 - a)) % 10000 << endl;
}

