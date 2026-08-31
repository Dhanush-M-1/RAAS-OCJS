#include <bits/stdc++.h>
using namespace std;
const bool debug = true;
int p[200001];
int pos[200001];
class seg_tree {
  int* st;
  int n;

 public:
  seg_tree(int a) {
    st = new int[2 * a];
    for (int i = 0; i < 2 * a; i++) st[i] = 0;
    n = a;
  }
  void set(int x) {
    x += n;
    st[x] = 1;
    x /= 2;
    while (x) {
      st[x] = st[2 * x] + st[2 * x + 1];
      x /= 2;
    }
  }
  int query(int l, int r) {
    l += n;
    r += n;
    int ans = 0;
    while (l < r) {
      if (l & 1) {
        ans += st[l++];
      }
      if (r & 1) {
        ans += st[--r];
      }
      l >>= 1;
      r >>= 1;
    }
    return ans;
  }
};
class median {
  priority_queue<int, vector<int>, greater<int>> higher;
  priority_queue<int> lower;
  long long int suml, sumr;

 public:
  median() {
    suml = 0;
    sumr = 0;
  }
  void insert(int n) {
    if ((lower.empty() && higher.empty()) || n < lower.top()) {
      lower.push(n);
      suml += n;
      if (lower.size() > higher.size() + 1) {
        higher.push(lower.top());
        sumr += lower.top();
        suml -= lower.top();
        lower.pop();
      }
    } else {
      higher.push(n);
      sumr += n;
      if (higher.size() > lower.size()) {
        lower.push(higher.top());
        suml += higher.top();
        sumr -= higher.top();
        higher.pop();
      }
    }
  }
  int get_median() { return lower.top(); }
  long long get_swaps() {
    long long int n = lower.size();
    long long int l = lower.top() * n - suml - ((n) * (n - 1)) / 2;
    n = higher.size();
    long long r = sumr - lower.top() * n - ((n) * (n + 1)) / 2;
    return l + r;
  }
};
int main() {
  int n;
  cin >> n;
  for (int z = 1; z < n + 1; z++) {
    cin >> p[z];
    pos[p[z]] = z;
  }
  seg_tree cind(n + 1);
  median med;
  long long inv = 0;
  for (int z = 1; z < n + 1; z++) {
    inv += cind.query(pos[z], n + 1);
    cind.set(pos[z]);
    med.insert(pos[z]);
    cout << inv + med.get_swaps() << " ";
  }
  cout << endl;
}
