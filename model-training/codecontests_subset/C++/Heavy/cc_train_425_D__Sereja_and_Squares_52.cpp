#include <bits/stdc++.h>
using namespace std;
bool exist(pair<int, int> p, vector<vector<int> > &H) {
  if (p.second < 0 || p.second >= H.size()) return 0;
  return binary_search(H[p.second].begin(), H[p.second].end(), p.first);
}
int main() {
  vector<vector<int> > H(100010);
  vector<vector<int> > V(100010);
  int N;
  cin >> N;
  for (int i = 0; i < N; ++i) {
    pair<int, int> p;
    cin >> p.first >> p.second;
    H[p.second].push_back(p.first);
  }
  for (int i = 0; i < H.size(); ++i) sort(H[i].begin(), H[i].end());
  int THRESHOLD = sqrt(N) + 1;
  int CNT = 0, oC = 0;
  for (int i = 0; i < H.size(); ++i) {
    if (H[i].size() && H[i].size() <= THRESHOLD) {
      for (int j = 0; j < H[i].size(); ++j) {
        int x1 = H[i][j];
        for (int k = j + 1; k < H[i].size(); ++k) {
          oC++;
          int x2 = H[i][k];
          int L = x2 - x1;
          if (i + L < H.size() && H[i + L].size() > THRESHOLD)
            CNT += exist(pair<int, int>(x1, i + L), H) &&
                   exist(pair<int, int>(x2, i + L), H);
          CNT += exist(pair<int, int>(x1, i - L), H) &&
                 exist(pair<int, int>(x2, i - L), H);
        }
      }
    } else if (H[i].size()) {
      for (int j = 0; j < H[i].size(); ++j) V[H[i][j]].push_back(i);
    }
  }
  for (int i = 0; i < V.size(); ++i) {
    for (int j = 0; j < V[i].size(); ++j) {
      int y1 = V[i][j];
      for (int k = j + 1; k < V[i].size(); ++k) {
        int y2 = V[i][k];
        int L = y2 - y1;
        CNT += exist(pair<int, int>(i - L, y1), H) &&
               exist(pair<int, int>(i - L, y2), H);
      }
    }
  }
  cout << CNT << endl;
}
