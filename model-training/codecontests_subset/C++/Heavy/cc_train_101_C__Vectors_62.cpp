#include <bits/stdc++.h>
using namespace std;
template <typename T>
void UpdateMax(T& a, T b) {
  if (a < b) a = b;
}
template <typename T>
void UpdateMin(T& a, T b) {
  if (a > b) a = b;
}
template <typename T>
inline void read(T& x) {
  x = 0;
  char c = getchar();
  int flag = 1;
  while (!isdigit(c)) {
    if (c == '-') flag = -1;
    c = getchar();
  }
  while (isdigit(c)) {
    x = x * 10 + c - '0';
    c = getchar();
  }
  x *= flag;
}
template <typename T>
void Unique(vector<T>& vec) {
  sort(vec.begin(), vec.end());
  vec.erase(unique(vec.begin(), vec.end()), vec.end());
}
template <typename T>
void Relabel(vector<T>& vec, T& value) {
  value = lower_bound(vec.begin(), vec.end(), value) - vec.begin() + 1;
}
template <typename T, typename V>
void Print(const pair<T, V>& x) {
  cout << x.first << " @ " << x.second << " | ";
}
template <typename T>
void Print(const T& x) {
  cout << x << " ";
}
template <typename T>
void Pcon(const T& x) {
  cout << "\nsize: " << x.size() << endl;
  for (const auto& item : x) Print(item);
}
std::vector<int> LABS;
template <typename T>
void Print(const T* x, int offset, int loop) {
  for (int i = 0; i <= loop; i++) {
    cout << "[";
    for (int item : LABS) cout << item - offset << ",";
    cout << i - offset << "]:";
    cout << x[i] << " ";
  }
}
template <typename T, typename... Args>
void Print(const T* f, int offset, int loop, Args... args) {
  for (int i = 0; i <= loop; i++) {
    LABS.push_back(i);
    Print(f[i], offset, args...);
    cout << endl;
    LABS.pop_back();
  }
}
template <typename T, typename V>
bool Has(T& cluster, const V& item) {
  return cluster.find(item) != cluster.end();
}
int Logn(long long x) {
  int cnt = 0;
  while (x) {
    ++cnt;
    x >>= 1;
  }
  return cnt;
}
const int MOD = 1e9 + 7;
const int N = 2e5 + 5;
const int dir[4][2] = {{-1, 0}, {0, -1}, {1, 0}, {1, 0}};
struct Edg {
  int x, y, z;
  friend bool operator<(const Edg& lhs, const Edg& rhs) {
    return lhs.z < rhs.z;
  }
} edg[N];
bool vis[N], used[N];
clock_t start_time;
int t, n, m;
int f[N];
vector<int> G[N];
inline void SetClock() { start_time = clock(); }
bool TimeOut(size_t ms) {
  if (1000 * (clock() - start_time) >= ms * ((clock_t)1000)) return true;
  return false;
}
inline pair<int, int> DeSerialize(int c) { return {(c) / m, (c) % m}; }
template <typename T, typename V>
inline void Add(T& v, const V& delta) {
  v += delta;
  if (v >= MOD) v -= MOD;
}
long long a1, a2, b1, b2, c1, c2;
bool check(long long a1, long long a2) {
  long long t1 = b1 + a1, t2 = b2 + a2;
  long long d1 = t1 - t2, d2 = t1 + t2;
  if (c1 == 0 && c2 == 0) {
    return d1 == 0 && d2 == 0;
  }
  if (c1 == 0) {
    return d1 % c2 == 0 && d2 % c2 == 0;
  }
  if (c2 == 0) {
    return d1 % c1 == 0 && d2 % c1 == 0;
  }
  if ((d2 * c1 - d1 * c2) % (c1 * c1 + c2 * c2) != 0) {
    return false;
  }
  long long b = (d2 * c1 - d1 * c2) / (c1 * c1 + c2 * c2);
  if ((d1 + b * c2) % c1 != 0) {
    return false;
  }
  long long a = (d1 + b * c2) / c1;
  return (a & 1) == (b & 1);
}
int main() {
  srand(time(0));
  SetClock();
  cin.sync_with_stdio(false);
  cin >> a1 >> a2;
  cin >> b1 >> b2;
  cin >> c1 >> c2;
  if (check(a1, a2) || check(a2, -a1) || check(-a1, -a2) || check(-a2, a1)) {
    cout << "YES" << endl;
  } else {
    cout << "NO" << endl;
  }
}
