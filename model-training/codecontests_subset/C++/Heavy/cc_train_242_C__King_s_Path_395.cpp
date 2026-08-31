#include <bits/stdc++.h>
using namespace std;
map<pair<int, int>, bool> mp;
map<pair<int, int>, int> mp2;
queue<pair<int, int> > q;
pair<int, int> pi;
pair<int, int> pe;
void bfs() {
  q.push(pi);
  int length = 0;
  while (q.size()) {
    length++;
    int sizee = q.size();
    while (sizee--) {
      pair<int, int> i;
      i = q.front();
      q.pop();
      if (mp[{i.first - 1, i.second - 1}] == 1) {
        mp[{i.first - 1, i.second - 1}] = 0;
        q.push({i.first - 1, i.second - 1});
        mp2[{i.first - 1, i.second - 1}] = length;
      }
      if (mp[{i.first - 1, i.second}] == 1) {
        mp[{i.first - 1, i.second}] = 0;
        q.push({i.first - 1, i.second});
        mp2[{i.first - 1, i.second}] = length;
      }
      if (mp[{i.first - 1, i.second + 1}] == 1) {
        mp[{i.first - 1, i.second + 1}] = 0;
        q.push({i.first - 1, i.second + 1});
        mp2[{i.first - 1, i.second + 1}] = length;
      }
      if (mp[{i.first, i.second - 1}] == 1) {
        mp[{i.first, i.second - 1}] = 0;
        q.push({i.first, i.second - 1});
        mp2[{i.first, i.second - 1}] = length;
      }
      if (mp[{i.first, i.second + 1}] == 1) {
        mp[{i.first, i.second + 1}] = 0;
        q.push({i.first, i.second + 1});
        mp2[{i.first, i.second + 1}] = length;
      }
      if (mp[{i.first + 1, i.second - 1}] == 1) {
        mp[{i.first + 1, i.second - 1}] = 0;
        q.push({i.first + 1, i.second - 1});
        mp2[{i.first + 1, i.second - 1}] = length;
      }
      if (mp[{i.first + 1, i.second + 1}] == 1) {
        mp[{i.first + 1, i.second + 1}] = 0;
        q.push({i.first + 1, i.second + 1});
        mp2[{i.first + 1, i.second + 1}] = length;
      }
      if (mp[{i.first + 1, i.second}] == 1) {
        mp[{i.first + 1, i.second}] = 0;
        q.push({i.first + 1, i.second});
        mp2[{i.first + 1, i.second}] = length;
      }
    }
  }
}
int main() {
  cin >> pi.first >> pi.second;
  cin >> pe.first >> pe.second;
  int x;
  cin >> x;
  while (x--) {
    int a, b, c;
    cin >> a >> b >> c;
    for (int w = b; w <= c; w++) mp[{a, w}] = 1;
  }
  bfs();
  if (mp2[pe] == 0) {
    cout << "-1" << endl;
  } else {
    cout << mp2[pe] << endl;
  }
  return 0;
}
