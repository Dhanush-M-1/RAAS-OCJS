#include <bits/stdc++.h>
using namespace std;
int dx[] = {1, -1, 0, 0};
int dy[] = {0, 0, 1, -1};
int dddx[] = {1, -1, 0, 0, 1, 1, -1, -1};
int dddy[] = {0, 0, 1, -1, 1, -1, 1, -1};
vector<pair<long long int, long long int> > vec;
int n;
long long int tree[(int)(2 * 1e5 + 1)], tree2[(int)(2 * 1e5 + 1)];
void atualiza(int x, int v) {
  for (; x < n; x = x | (x + 1)) tree[x] += v;
}
void atualiza2(int x, int v) {
  for (; x < n; x = x | (x + 1)) tree2[x] += v;
}
long long int sum(long long int x) {
  long long int s = 0;
  for (; x >= 0; x = (x & (x + 1)) - 1) s += tree[x];
  return s;
}
long long int sum2(int x) {
  long long int s = 0;
  for (; x >= 0; x = (x & (x + 1)) - 1) s += tree2[x];
  return s;
}
void compress() {
  vector<int> aux2;
  for (int i = 0; i < n; i++) aux2.push_back(vec[i].second);
  sort(aux2.begin(), aux2.end());
  for (int j = 0; j < n; j++) {
    auto i = vec[j];
    vec[j].second =
        lower_bound(aux2.begin(), aux2.end(), i.second) - aux2.begin();
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cin >> n;
  vector<int> aux;
  for (int i = 0; i < n; i++) {
    int a;
    cin >> a;
    vec.push_back({a, 1});
  }
  for (int i = 0; i < n; i++) {
    int a;
    cin >> a;
    vec[i].second = a;
  }
  sort(vec.begin(), vec.end());
  compress();
  for (int i = 0; i < n; i++) aux.push_back(vec[i].second);
  sort(aux.begin(), aux.end());
  long long int ans = 0;
  for (int i = 0; i < n; i++) {
    int pos = lower_bound(aux.begin(), aux.end(), vec[i].second) - aux.begin();
    ans += (sum2(pos) * vec[i].first - sum(pos));
    atualiza(pos, vec[i].first);
    atualiza2(pos, 1);
  }
  cout << ans << "\n";
  return 0;
}
