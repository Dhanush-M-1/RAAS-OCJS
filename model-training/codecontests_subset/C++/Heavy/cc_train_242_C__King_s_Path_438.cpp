#include <bits/stdc++.h>
using namespace std;
int main() {
  queue<pair<int, int> > bfs;
  queue<int> cekori;
  pair<int, int> start, kraj;
  map<pair<int, int>, int> mapa;
  map<pair<int, int>, int>::iterator it;
  int n, i, j, one, two, three;
  cin >> start.first >> start.second >> kraj.first >> kraj.second;
  cin >> n;
  for (i = 0; i < n; i++) {
    cin >> one >> two >> three;
    for (j = two; j <= three; j++) {
      pair<int, int> temp = make_pair(one, j);
      mapa[temp] = 1000000000;
    }
  }
  mapa[start] = 0;
  bfs.push(start);
  cekori.push(0);
  while (!bfs.empty()) {
    pair<int, int> temp = bfs.front();
    int cek = cekori.front();
    bfs.pop();
    cekori.pop();
    pair<int, int> poteg = make_pair(temp.first - 1, temp.second);
    if ((temp.first - 1 >= 0) && (mapa.find(poteg) != mapa.end()) &&
        (mapa[poteg] > cek + 1)) {
      mapa[poteg] = cek + 1;
      bfs.push(poteg);
      cekori.push(cek + 1);
    }
    poteg = make_pair(temp.first + 1, temp.second);
    if ((temp.first + 1 <= 1000000000) && (mapa.find(poteg) != mapa.end()) &&
        (mapa[poteg] > cek + 1)) {
      mapa[poteg] = cek + 1;
      bfs.push(poteg);
      cekori.push(cek + 1);
    }
    poteg = make_pair(temp.first, temp.second - 1);
    if ((temp.second - 1 >= 0) && (mapa.find(poteg) != mapa.end()) &&
        (mapa[poteg] > cek + 1)) {
      mapa[poteg] = cek + 1;
      bfs.push(poteg);
      cekori.push(cek + 1);
    }
    poteg = make_pair(temp.first, temp.second + 1);
    if ((temp.second + 1 <= 1000000000) && (mapa.find(poteg) != mapa.end()) &&
        (mapa[poteg] > cek + 1)) {
      mapa[poteg] = cek + 1;
      bfs.push(poteg);
      cekori.push(cek + 1);
    }
    poteg = make_pair(temp.first - 1, temp.second + 1);
    if ((temp.second + 1 <= 1000000000) && (mapa.find(poteg) != mapa.end()) &&
        (mapa[poteg] > cek + 1)) {
      mapa[poteg] = cek + 1;
      bfs.push(poteg);
      cekori.push(cek + 1);
    }
    poteg = make_pair(temp.first + 1, temp.second + 1);
    if ((temp.second + 1 <= 1000000000) && (mapa.find(poteg) != mapa.end()) &&
        (mapa[poteg] > cek + 1)) {
      mapa[poteg] = cek + 1;
      bfs.push(poteg);
      cekori.push(cek + 1);
    }
    poteg = make_pair(temp.first + 1, temp.second - 1);
    if ((temp.second + 1 <= 1000000000) && (mapa.find(poteg) != mapa.end()) &&
        (mapa[poteg] > cek + 1)) {
      mapa[poteg] = cek + 1;
      bfs.push(poteg);
      cekori.push(cek + 1);
    }
    poteg = make_pair(temp.first - 1, temp.second - 1);
    if ((temp.second + 1 <= 1000000000) && (mapa.find(poteg) != mapa.end()) &&
        (mapa[poteg] > cek + 1)) {
      mapa[poteg] = cek + 1;
      bfs.push(poteg);
      cekori.push(cek + 1);
    }
    if (mapa[kraj] < 1000000000) {
      cout << mapa[kraj];
      return 0;
    }
  }
  cout << "-1";
  return 0;
}
