#include <bits/stdc++.h>
using namespace std;
void solve() {
  int n, k;
  cin >> n >> k;
  priority_queue<pair<int, int>, vector<pair<int, int> >,
                 greater<pair<int, int> > >
      pq;
  vector<int> t(n), a(n), b(n);
  int cnt1 = 0, cnt2 = 0;
  int cnt3 = 0;
  priority_queue<int, vector<int>, greater<int> > pqboth;
  for (int i = 0; i < n; i++) {
    cin >> t[i] >> a[i] >> b[i];
    if (a[i] != 0 || b[i] != 0) pq.push({t[i], i});
    if (a[i] == 1 && b[i] == 1) {
      pqboth.push(t[i]);
      cnt3++;
    }
    if (a[i] == 1) cnt1++;
    if (b[i] == 1) cnt2++;
  }
  if (cnt1 < k || cnt2 < k) {
    cout << "-1\n";
    return;
  }
  cnt1 = 0, cnt2 = 0;
  long long int time = 0;
  priority_queue<int> pq3, pq4;
  int cnt4 = 0;
  while (!pq.empty() && (cnt1 < k || cnt2 < k)) {
    int x = pq.top().first;
    int y = pq.top().second;
    time += (long long int)x;
    if (a[y] == 1 && b[y] == 1) cnt4++;
    if (a[y] == 1) cnt1++;
    if (b[y] == 1) cnt2++;
    if (a[y] == 1 && b[y] == 0) {
      pq3.push(x);
    }
    if (a[y] == 0 && b[y] == 1) {
      pq4.push(x);
    }
    pq.pop();
  }
  while (cnt4 > 0 && !pqboth.empty()) {
    cnt4--;
    pqboth.pop();
  }
  while (cnt1 > k && !pq3.empty()) {
    cnt1--;
    time -= (long long int)pq3.top();
    pq3.pop();
  }
  while (cnt2 > k && !pq4.empty()) {
    cnt2--;
    time -= (long long int)pq4.top();
    pq4.pop();
  }
  while (!pqboth.empty() && !pq3.empty() && !pq4.empty()) {
    int x = pqboth.top();
    int y = pq3.top();
    int z = pq4.top();
    if (x < y + z)
      time += (long long int)(x - y - z);
    else
      break;
    pqboth.pop();
    pq3.pop();
    pq4.pop();
  }
  cout << time << "\n";
}
int main() {
  solve();
  return 0;
}
