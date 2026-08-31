#include <bits/stdc++.h>
using namespace std;
template <typename A, typename B>
string to_string(pair<A, B> p);
template <typename A, typename B, typename C>
string to_string(tuple<A, B, C> p);
template <typename A, typename B, typename C, typename D>
string to_string(tuple<A, B, C, D> p);
string to_string(const string& second) { return '"' + second + '"'; }
string to_string(char c) {
  string second;
  second += c;
  return second;
}
string to_string(const char* second) { return to_string((string)second); }
string to_string(bool b) { return (b ? "1" : "0"); }
string to_string(vector<bool> v) {
  bool first = true;
  string res = "{";
  for (long long i = 0; i < static_cast<long long>(v.size()); i++) {
    if (!first) {
      res += ", ";
    }
    first = false;
    res += to_string(v[i]);
  }
  res += "}";
  return res;
}
template <size_t N>
string to_string(bitset<N> v) {
  string res = "";
  for (size_t i = 0; i < N; i++) {
    res += static_cast<char>('0' + v[i]);
  }
  return res;
}
template <typename A>
string to_string(A v) {
  bool first = true;
  string res = "{";
  for (const auto& x : v) {
    if (!first) {
      res += ", ";
    }
    first = false;
    res += to_string(x);
  }
  res += "}";
  return res;
}
template <typename A, typename B>
string to_string(pair<A, B> p) {
  return "(" + to_string(p.first) + ", " + to_string(p.second) + ")";
}
template <typename A, typename B, typename C>
string to_string(tuple<A, B, C> p) {
  return "(" + to_string(get<0>(p)) + ", " + to_string(get<1>(p)) + ", " +
         to_string(get<2>(p)) + ")";
}
template <typename A, typename B, typename C, typename D>
string to_string(tuple<A, B, C, D> p) {
  return "(" + to_string(get<0>(p)) + ", " + to_string(get<1>(p)) + ", " +
         to_string(get<2>(p)) + ", " + to_string(get<3>(p)) + ")";
}
void debug_out() { cerr << "\n"; }
template <typename Head, typename... Tail>
void debug_out(Head H, Tail... T) {
  cerr << " " << to_string(H);
  debug_out(T...);
}
void Clearing_out() { return; }
template <typename Head, typename... Tail>
void Clearing_out(Head& H, Tail&... T) {
  H.clear();
  Clearing_out(T...);
}
struct custom_hash {
  static uint64_t splitmix64(uint64_t x) {
    x += 0x9e3779b97f4a7c15;
    x = (x ^ (x >> 30)) * 0xbf58476d1ce4e5b9;
    x = (x ^ (x >> 27)) * 0x94d049bb133111eb;
    return x ^ (x >> 31);
  }
  size_t operator()(uint64_t x) const {
    static const uint64_t FIXED_RANDOM =
        chrono::steady_clock::now().time_since_epoch().count();
    return splitmix64(x + FIXED_RANDOM);
  }
};
void time() {
  cerr << "Time elapsed: " << 1.0 * clock() / CLOCKS_PER_SEC << " s.\n";
}
void hi() {
  static long long i = 0;
  cerr << "Check Point : " << ++i << "\n";
  return;
}
long long stoi1(string str) {
  bool negative;
  if (str[0] == '-') {
    negative = true;
    str = str.substr(1);
  } else {
    negative = false;
  }
  long long n = str.length();
  long long number = 0;
  long long pos = 1;
  for (long long i = n - 1; i >= 0; i--) {
    number = number + (str[i] - '0') * pos;
    pos = pos * 10;
  }
  if (negative) number = -number;
  return number;
}
long long power(long long a, long long n) {
  long long res = 1;
  while (n > 0) {
    if (n % 2 != 0) {
      res = res * a;
      n--;
    } else if (n % 2 == 0) {
      a = a * a;
      n = n / 2;
    }
  }
  return res;
}
pair<long long, long long> min(vector<long long> v, bool first = true) {
  bool last = !first;
  long long mini = 1000000000000000007;
  long long mini_index = -1;
  long long n = (long long)v.size();
  for (long long i = 0; i < n; i++) {
    if ((mini > v[i] && first) || (mini >= v[i] && last)) {
      mini = v[i];
      mini_index = i;
    }
  }
  return {mini_index, mini};
}
pair<long long, long long> max(vector<long long> v, bool first = true) {
  bool last = !first;
  long long maxi = -1000000000000000007;
  long long maxi_index = -1;
  long long n = (long long)v.size();
  for (long long i = 0; i < n; i++) {
    if ((maxi < v[i] && first) || (maxi <= v[i] && last)) {
      maxi = v[i];
      maxi_index = i;
    }
  }
  return {maxi_index, maxi};
}
long long sum(vector<long long> v, long long start = 0, long long last = -1) {
  if (last == -1) last = (long long)v.size() - 1;
  long long ans = 0;
  for (long long i = start; i <= last; i++) {
    ans = ans + v[i];
  }
  return ans;
}
long long len(vector<long long> v) { return (long long)v.size(); }
long long rand(long long a, long long b) { return a + rand() % (b - a + 1); }
vector<long long> generate_random_vector() {
  vector<long long> v;
  long long n = rand(10, 20);
  set<long long> used;
  for (long long i = 0; i < n; ++i) {
    long long x;
    do {
      x = rand(10, 1000);
    } while (used.count(x));
    v.push_back(x);
    used.insert(x);
  }
  return v;
}
const long long max_size = 1e6 + 10000;
const double eps = 1e-18;
signed main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long t;
  t = 1;
  while (t--) {
    long long n, x;
    cin >> n >> x;
    vector<long long> v(n + 1);
    for (long long i = 1; i <= n; i++) {
      cin >> v[i];
    }
    vector<long long> in(n + 1);
    for (long long i = 1; i <= n; i++) {
      bool found = false;
      for (long long j = 1; j <= n; j++) {
        if (v[j] == i) {
          found = true;
          break;
        }
      }
      if (found) {
        in[i] = 1;
      }
    }
    long long start = x;
    long long length = 0;
    while (start != 0) {
      length++;
      start = v[start];
    }
    long long p = length;
    vector<long long> v_length;
    for (long long i = 1; i <= n; i++) {
      if (in[i] == 0) {
        long long start = i;
        long long length = 0;
        bool smart = false;
        while (start != 0) {
          length++;
          if (start == x) smart = true;
          start = v[start];
        }
        if (!smart) v_length.push_back(length);
      }
    }
    long long v_size = v_length.size();
    sort(v_length.begin(), v_length.end());
    cerr << "["
         << "v_length"
         << "]:",
        debug_out(v_length);
    vector<vector<long long>> matrix(v_size, vector<long long>(n + 1));
    if (v_length.size() == 0) {
      cout << p << "\n";
      continue;
    }
    matrix[0][v_length[0]] = 1;
    matrix[0][0] = 1;
    for (long long i = 1; i < v_size; i++) {
      for (long long j = 0; j <= n; j++) {
        if (matrix[i - 1][j] == 1) {
          matrix[i][j] = 1;
        } else {
          if (j >= v_length[i]) {
            matrix[i][j] = matrix[i - 1][j - v_length[i]];
          } else {
            matrix[i][j] = 0;
          }
        }
      }
    }
    vector<long long> final(n + 1);
    for (long long i = 1; i <= n; i++) {
      if (matrix[v_size - 1][i] == 1 && i + p <= n) {
        final[i + p] = 1;
      }
    }
    cout << p << "\n";
    for (long long i = 1; i <= n; i++) {
      if (final[i] == 1) {
        cout << i << "\n";
      }
    }
  }
  time();
  return 0;
}
