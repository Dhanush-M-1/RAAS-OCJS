#include <bits/stdc++.h>
using namespace std;
inline long long modadd(long long n, long long m) {
  long long sum = ((n + m) % 1000000007 + 1000000007) % 1000000007;
  return sum;
}
inline long long modsub(long long n, long long m) {
  long long diff =
      ((n - m + 1000000007) % 1000000007 + 1000000007) % 1000000007;
  return diff;
}
inline long long modpro(long long n, long long m) {
  long long pro = ((n * m) % 1000000007 + 1000000007) % 1000000007;
  return pro;
}
inline long long pow(int x, int y) {
  long long res = 1;
  while (y > 0) {
    if (y & 1) res = res * x;
    y = y >> 1;
    x = x * x;
  }
  return res;
}
inline long long powmod(long long x, long long y) {
  long long res = 1;
  while (y > 0) {
    if (y & 1) res = modpro(res, x);
    y = y >> 1;
    x = modpro(x, x);
  }
  return res;
}
template <class T, class U>
bool comparep(const pair<T, U>& i, const pair<T, U>& j) {
  return i.first > j.first;
}
template <class T, class U>
bool comparep2(const pair<T, U>& i, const pair<T, U>& j) {
  return ((i.second < j.second) ||
          ((i.second == j.second) && i.first < j.first));
}
template <typename T>
T gcd(T a, T b) {
  if (a == 0) return b;
  if (b == 0) return a;
  T t;
  while ((a > 0) && (b > 0)) {
    t = a;
    a = b % a;
    b = t;
  }
  return max(a, b);
}
template <typename T>
T maxof(T n_args, ...) {
  va_list ap;
  va_start(ap, n_args);
  T big = va_arg(ap, T);
  for (int i = 2; i <= n_args; i++) {
    T a = va_arg(ap, T);
    if (a > big) big = a;
  }
  va_end(ap);
  return big;
}
template <typename T>
T gcdarr(T a[], int n) {
  T gc = gcd<T>(a[0], a[1]);
  for (int i = 2; i < n; i++) {
    gc = gcd<T>(gc, a[i]);
  }
  return gc;
}
template <typename T>
T maxarr(T a[], int n) {
  T big = a[0];
  for (int i = 1; i < n; i++) {
    big = max(big, a[i]);
  }
  return big;
}
template <typename T>
T minarr(T a[], int n) {
  T small = a[0];
  for (int i = 1; i < n; i++) {
    small = min(small, a[i]);
  }
  return small;
}
long long choose(long long n, int k) {
  long long res = 1;
  if (k > n - k) k = n - k;
  for (int i = 0; i < k; ++i) {
    res *= (n - i);
    res /= (i + 1);
  }
  return res;
}
class Graph {
 public:
  int V;
  vector<int> v[25];
  bool visited[25] = {0};
  queue<int> q;
  Graph(int V) { this->V = V; }
  void addEdge(int a, int b) {
    v[a].push_back(b);
    v[b].push_back(a);
  }
  void dfs(int x) {
    if (visited[x] == 0) {
      visited[x] = 1;
      for (int u : v[x]) {
        dfs(u);
      }
    }
  }
  void bfs(int n, int x) {
    visited[x] = 1;
    q.push(x);
    while (!q.empty()) {
      int s = q.front();
      q.pop();
      for (int u : v[s]) {
        if (visited[u] == 1) continue;
        visited[u] = 1;
        q.push(u);
      }
    }
  }
  int connectedcomponents(int n) {
    int ans = 0;
    for (int i = 1; i < n + 1; i++) {
      if (!visited[i]) {
        ans++;
        dfs(i);
      }
    }
    return ans;
  }
};
template <typename T>
T findpower(T n, T p) {
  T x = 0;
  while (n) {
    n /= p;
    x += n;
  }
  return x;
}
void primeFactors(int n) {
  while (n % 2 == 0) {
    cout << 2 << " ";
    n = n / 2;
  }
  for (int i = 3; i <= sqrt(n); i = i + 2) {
    while (n % i == 0) {
      cout << i << " ";
      n = n / i;
    }
  }
  if (n > 2) cout << n << " ";
}
int main() {
  int erer;
  erer = 1;
  cin >> erer;
  while (erer--) {
    int l, r, d;
    cin >> l >> r >> d;
    int temp;
    temp = d;
    if (temp == 0 || (temp >= l)) {
      if (r % d == 0) {
        temp = r + d;
      } else
        temp = ((r / d) + 1) * d;
    }
    cout << temp << endl;
  }
  return 0;
}
