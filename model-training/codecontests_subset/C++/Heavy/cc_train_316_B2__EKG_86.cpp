#include <bits/stdc++.h>
using namespace std;
int main() {
  int N, X;
  cin >> N >> X;
  int nn;
  int leads[N];
  int follows[N];
  bool visited[N];
  int curr;
  for (nn = 0; nn < N; ++nn) {
    leads[nn] = follows[nn] = -1;
    visited[nn] = false;
  }
  for (nn = 0; nn < N; ++nn) {
    cin >> curr;
    if (curr == 0) continue;
    leads[nn] = (curr - 1);
    follows[curr - 1] = nn;
  }
  vector<deque<int> *> streams;
  map<int, deque<int> *> streamMap;
  int next;
  for (nn = 0; nn < N; ++nn) {
    if (visited[nn]) continue;
    deque<int> *currdeq = new deque<int>;
    streams.push_back(currdeq);
    currdeq->push_back(nn);
    visited[nn] = true;
    streamMap[nn] = currdeq;
    next = leads[nn];
    while (next >= 0) {
      currdeq->push_front(next);
      visited[next] = true;
      streamMap[next] = currdeq;
      next = leads[next];
    }
    next = follows[nn];
    while (next >= 0) {
      currdeq->push_back(next);
      visited[next] = true;
      streamMap[next] = currdeq;
      next = follows[next];
    }
  }
  int offset = 0;
  deque<int> *myDeq = streamMap[X - 1];
  deque<int>::iterator dqi = myDeq->begin(), dqe = myDeq->end();
  for (; dqi != dqe; ++dqi) {
    ++offset;
    if ((*dqi) == X - 1) break;
  }
  set<int> possibilities;
  possibilities.insert(offset);
  vector<deque<int> *>::iterator svi, sve;
  svi = streams.begin();
  sve = streams.end();
  vector<int> deqszs;
  for (; svi != sve; ++svi) {
    if ((*svi) == myDeq) continue;
    deqszs.push_back((*svi)->size());
  }
  sort(deqszs.begin(), deqszs.end());
  vector<int>::iterator dsi = deqszs.begin(), dse = deqszs.end();
  set<int>::iterator psi, pse;
  int currDS;
  for (; dsi != dse; ++dsi) {
    currDS = *dsi;
    set<int> newPosss;
    for (psi = possibilities.begin(), pse = possibilities.end(); psi != pse;
         ++psi) {
      newPosss.insert((*psi) + currDS);
    }
    possibilities.insert(newPosss.begin(), newPosss.end());
  }
  psi = possibilities.begin();
  pse = possibilities.end();
  for (; psi != pse; ++psi) {
    cout << *psi << endl;
  }
  svi = streams.begin();
  sve = streams.end();
  for (; svi != sve; ++svi) {
    delete *svi;
  }
  return 0;
}
