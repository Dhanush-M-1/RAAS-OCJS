#include <bits/stdc++.h>
using namespace std;

int main() {
  int N;
  cin >> N;
  map<char, vector<int> > m;
  m['S'] = vector<int>(13, 0);
  m['H'] = vector<int>(13, 0);
  m['C'] = vector<int>(13, 0);
  m['D'] = vector<int>(13, 0);

  for (int i = 0; i < N; i++) {
    char S;
    int rank;
    cin >> S >> rank;
    m[S].at(rank - 1) = 1;
  }

  string s = "SHCD";
  for (int j = 0; j < s.size(); j++) {
    for (int i = 0; i < 13; i++)
      if (!m[s.at(j)].at(i)) {
        cout << s.at(j) << " " << i+1 << endl;
      }
  }
}

