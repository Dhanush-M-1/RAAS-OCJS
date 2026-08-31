#include <bits/stdc++.h>
using namespace std;
template <class T>
void splitstr(const string &s, vector<T> &out) {
  istringstream in(s);
  out.clear();
  copy(istream_iterator<T>(in), istream_iterator<T>(), back_inserter(out));
}
template <class T>
T gcd(T a, T b) {
  return b ? gcd(b, a % b) : a;
}
static void redirect(int argc, const char **argv) {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  if (argc > 1) {
    static filebuf f;
    f.open(argv[1], ios::in);
    cin.rdbuf(&f);
    if (!cin) {
      cerr << "Failed to open '" << argv[1] << "'" << endl;
      exit(1);
    }
  }
  if (argc > 2) {
    static filebuf f;
    f.open(argv[2], ios::out | ios::trunc);
    cout.rdbuf(&f);
    if (!cout) {
      cerr << "Failed to open '" << argv[2] << "'" << endl;
    }
  }
  cin.exceptions(ios::failbit);
}
struct minion {
  int a, b;
  int idx;
  bool operator<(const minion &other) const { return b < other.b; }
};
int main(int argc, const char **argv) {
  redirect(argc, argv);
  int T;
  cin >> T;
  for (int cas = 0; cas < T; cas++) {
    int N, K;
    cin >> N >> K;
    vector<minion> m(N);
    for (int i = 0; i < N; i++) {
      cin >> m[i].a >> m[i].b;
      m[i].idx = i + 1;
    }
    sort(begin(m), end(m));
    vector<vector<int> > dp(N + 1, vector<int>(K + 1, INT_MIN / 2));
    vector<vector<int> > team(N + 1, vector<int>(K + 1, 0));
    dp[0][0] = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j <= min(i, K); j++)
        dp[i + 1][j] = dp[i][j] + m[i].b * (K - 1);
      for (int j = 0; j <= min(i, K - 1); j++) {
        int score = dp[i][j] + m[i].a + j * m[i].b;
        if (score > dp[i + 1][j + 1]) {
          dp[i + 1][j + 1] = score;
          team[i + 1][j + 1] = 1;
        }
      }
    }
    int n = N;
    int k = K;
    vector<int> in, out;
    while (n > 0) {
      int t = team[n][k];
      n--;
      k -= t;
      if (t)
        in.push_back(m[n].idx);
      else
        out.push_back(m[n].idx);
    }
    reverse(begin(in), end(in));
    cout << ((long long)(in).size()) + 2 * ((long long)(out).size()) << '\n';
    for (int i = 0; i < K - 1; i++) cout << in[i] << ' ';
    for (int v : out) cout << v << ' ' << -v << ' ';
    cout << in.back() << '\n';
  }
  return 0;
}
