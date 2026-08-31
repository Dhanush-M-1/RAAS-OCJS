#include <bits/stdc++.h>
template <class C, class E>
inline bool contains(const C& container, const E& element) {
  return container.find(element) != container.end();
}
template <class T>
inline void checkmin(T& a, T b) {
  if (b < a) a = b;
}
template <class T>
inline void checkmax(T& a, T b) {
  if (b > a) a = b;
}
using namespace std;
vector<pair<int, int> > fr;
vector<set<int> > gr;
int n, m, k;
vector<bool> inTrip;
int inTripCount;
void Remove(int a, int b) {
  gr[a].erase(b);
  gr[b].erase(a);
}
int Deg(int a) { return gr[a].size(); }
vector<bool> InQueue;
void RemAll(queue<int>& toRemove) {
  while (!toRemove.empty()) {
    int iRem = toRemove.front();
    inTrip[iRem] = false;
    InQueue[iRem] = false;
    --inTripCount;
    toRemove.pop();
    for (int br : gr[iRem]) {
      gr[br].erase(iRem);
      if (Deg(br) < k && !InQueue[br]) {
        InQueue[br] = true;
        toRemove.push(br);
      }
    }
    gr[iRem].clear();
  }
}
void Process(pair<int, int> p) {
  if (!contains(gr[p.first], p.second)) return;
  Remove(p.first, p.second);
  queue<int> toRemove;
  if (inTrip[p.first] && Deg(p.first) < k) {
    InQueue[p.first] = true;
    toRemove.push(p.first);
  }
  if (inTrip[p.second] && Deg(p.second) < k) {
    InQueue[p.second] = true;
    toRemove.push(p.second);
  }
  RemAll(toRemove);
}
void Init() {
  queue<int> toRemove;
  for (int i = (0), _b = ((n)-1); i <= _b; i++) {
    if (Deg(i) < k) {
      InQueue[i] = true;
      toRemove.push(i);
    }
  }
  RemAll(toRemove);
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  cout << std::setprecision(15);
  cout << std::fixed;
  cin >> n >> m >> k;
  fr.resize(m);
  gr.resize(n);
  InQueue.resize(n);
  inTrip.resize(n, true);
  inTripCount = n;
  for (int i = (0), _b = ((m)-1); i <= _b; i++) {
    int a, b;
    cin >> a >> b;
    --a;
    --b;
    fr[i] = make_pair(a, b);
    gr[a].insert(b);
    gr[b].insert(a);
  }
  Init();
  vector<int> res;
  for (int i = (m - 1), _b = (0); i >= _b; i--) {
    res.push_back(inTripCount);
    if (i != 0) Process(fr[i]);
  }
  for (int i = (m - 1), _b = (0); i >= _b; i--) {
    cout << res[i] << endl;
  }
  return 0;
}
