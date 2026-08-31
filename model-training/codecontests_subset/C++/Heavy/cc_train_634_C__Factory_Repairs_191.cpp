#include <bits/stdc++.h>
using namespace std;
const int MAXN = 200005;
const int MAXINT = 1073741823;
struct node {
  int value = 0, low = 0, high = 0;
} segment[MAXN * 4];
int a, b;
vector<int> selection;
void select(int from, int to, int current, int beginning, int ending) {
  if (from > ending || to < beginning)
    return;
  else if (beginning <= from && to <= ending) {
    selection.push_back(current);
    return;
  }
  int mid = (from + to) / 2;
  select(from, mid, current * 2 + 1, beginning, ending);
  select(mid + 1, to, current * 2 + 2, beginning, ending);
  return;
}
void update(int from, int to, int current, int index, int value) {
  if (from > index || to < index)
    return;
  else if (from == to) {
    segment[current].value += value;
    segment[current].high = min(a, segment[current].value);
    segment[current].low = min(b, segment[current].value);
    return;
  }
  int mid = (from + to) / 2;
  update(from, mid, current * 2 + 1, index, value);
  update(mid + 1, to, current * 2 + 2, index, value);
  segment[current].low =
      segment[current * 2 + 1].low + segment[current * 2 + 2].low;
  segment[current].high =
      segment[current * 2 + 1].high + segment[current * 2 + 2].high;
  return;
}
void display(int from, int to, int current) {
  cout << from << ' ' << to << ' ' << current << ' ' << segment[current].low
       << ' ' << segment[current].high << '\n';
  if (from == to) return;
  int mid = (from + to) / 2;
  display(from, mid, current * 2 + 1);
  display(mid + 1, to, current * 2 + 2);
  return;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int n, k, t, type, day, value, answer;
  cin >> n >> k >> a >> b >> t;
  for (int q = 0; q < t; q++) {
    cin >> type >> day;
    day--;
    if (type == 1) {
      cin >> value;
      update(0, n - 1, 0, day, value);
    } else {
      answer = 0;
      if (day != 0) {
        selection.clear();
        select(0, n - 1, 0, 0, day - 1);
        for (int i : selection) answer += segment[i].low;
      }
      if (day != n - 1) {
        selection.clear();
        select(0, n - 1, 0, day + k, n - 1);
        for (int i : selection) answer += segment[i].high;
      }
      cout << answer << '\n';
    }
  }
  return 0;
}
