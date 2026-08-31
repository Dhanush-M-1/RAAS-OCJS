#include <bits/stdc++.h>
using namespace std;
int n;
int tab[1000001];
vector<int> V[3000001];
long long m = 0, p = 0, res = 0, tim = 0;
long long m_amount = 0, p_amount = 0;
bool ifmin[1000001];
void read_and_prepare() {
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> tab[i];
    if (tab[i] - i > 0) {
      p_amount++;
      p += tab[i] - i;
      V[tab[i] - i].push_back(i);
    } else {
      ifmin[i] = 1;
      m_amount++;
      m += i - tab[i];
    }
  }
  res = m + p;
}
void shifts() {
  for (int i = 1; i < n; i++) {
    int id = n - i + 1;
    m -= n - tab[id];
    p += tab[id] - 1;
    m_amount--;
    ifmin[id] = 0;
    p -= p_amount;
    m += m_amount;
    p_amount++;
    V[i + tab[id] - 1].push_back(id);
    for (unsigned int j = 0; j < V[i].size(); j++) {
      id = V[i][j];
      if (!ifmin[id]) {
        ifmin[id] = 1;
        p_amount--;
        m_amount++;
      }
    }
    if (m + p < res) {
      res = m + p;
      tim = i;
    }
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  read_and_prepare();
  shifts();
  cout << res << " " << tim << endl;
}
