#include <bits/stdc++.h>
using namespace std;
int tab_x[200000 + 5];
int tab_v[200000 + 5];
long long D_dist[550000 + 5];
int D_ile[550000 + 5];
int zakresy[550000 + 5][2];
int max_pot = 1;
int QUERRY_ile(int L, int R, int w) {
  if (zakresy[w][0] > R || L > zakresy[w][1]) return 0;
  if (L <= zakresy[w][0] && zakresy[w][1] <= R) return D_ile[w];
  return QUERRY_ile(L, R, w * 2) + QUERRY_ile(L, R, w * 2 + 1);
}
long long QUERRY_dist(int L, int R, int w) {
  if (zakresy[w][0] > R || L > zakresy[w][1]) return 0;
  if (L <= zakresy[w][0] && zakresy[w][1] <= R) return D_dist[w];
  return QUERRY_dist(L, R, w * 2) + QUERRY_dist(L, R, w * 2 + 1);
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) cin >> tab_x[i];
  for (int i = 0; i < n; i++) cin >> tab_v[i];
  vector<pair<int, int> > V_0;
  for (int i = 0; i < n; i++) V_0.push_back({tab_x[i], tab_v[i]});
  sort(V_0.begin(), V_0.end());
  for (int i = 0; i < n; i++) {
    tab_x[i] = V_0[i].first;
    tab_v[i] = V_0[i].second;
  }
  priority_queue<pair<int, int> > PQ;
  for (int i = 0; i < n; i++) PQ.push({-tab_v[i], i});
  int last_ = INT_MIN;
  int name_num = 0;
  while (!PQ.empty()) {
    int top_val = -PQ.top().first;
    int top_place = PQ.top().second;
    PQ.pop();
    if (top_val != last_) {
      name_num++;
      last_ = top_val;
    }
    tab_v[top_place] = name_num;
  }
  while (max_pot < name_num) max_pot *= 2;
  for (int i = max_pot; i < 2 * max_pot; i++)
    zakresy[i][0] = zakresy[i][1] = i - max_pot + 1;
  for (int i = max_pot - 1; i >= 1; i--) {
    zakresy[i][0] = zakresy[2 * i][0];
    zakresy[i][1] = zakresy[2 * i + 1][1];
  }
  long long RESULT = 0;
  for (int i = 0; i < n; i++) {
    long long akt_x = tab_x[i];
    int akt_v = tab_v[i];
    int ile_ = QUERRY_ile(1, akt_v, 1);
    long long suma_dist = QUERRY_dist(1, akt_v, 1);
    long long bazowy_koszt = ile_;
    bazowy_koszt *= akt_x;
    bazowy_koszt -= suma_dist;
    RESULT += bazowy_koszt;
    int w = max_pot + akt_v - 1;
    while (w) {
      D_ile[w]++;
      D_dist[w] += akt_x;
      w /= 2;
    }
  }
  cout << RESULT;
}
