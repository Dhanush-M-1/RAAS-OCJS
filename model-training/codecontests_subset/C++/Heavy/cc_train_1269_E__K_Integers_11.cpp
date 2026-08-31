#include <bits/stdc++.h>
using namespace std;
struct Node {
  Node *l, *r;
  int count;
  long long sum;
  int ask(int k, int ll, int rr) {
    if (ll == rr) {
      return count;
    }
    int mid = (ll + rr) >> 1;
    if (k <= mid) {
      return l ? l->ask(k, ll, mid) : 0;
    } else {
      return (l ? l->count : 0) + (r ? r->ask(k, mid + 1, rr) : 0);
    }
  }
  long long asksum(int k, int ll, int rr) {
    if (ll == rr) {
      return sum;
    }
    int mid = (ll + rr) >> 1;
    if (k <= mid) {
      return l ? l->asksum(k, ll, mid) : 0;
    } else {
      return (l ? l->sum : 0) + (r ? r->asksum(k, mid + 1, rr) : 0);
    }
  }
  void add(int, int, int, int);
} node[200005 * 25];
int cnt;
Node *getNode() {
  ++cnt;
  return node + cnt;
}
void Node::add(int k, int w, int ll, int rr) {
  ++count;
  sum += w;
  if (ll == rr) {
    return;
  }
  int mid = (ll + rr) >> 1;
  if (k <= mid) {
    if (l) {
      Node tmp = *l;
      l = getNode();
      (*l) = tmp;
    } else {
      l = getNode();
    }
    l->add(k, w, ll, mid);
  } else {
    if (r) {
      Node tmp = *r;
      r = getNode();
      (*r) = tmp;
    } else {
      r = getNode();
    }
    r->add(k, w, mid + 1, rr);
  }
}
int n;
Node root[200005];
int rf(int a, int b) {
  int l = 0, r = n, mid;
  while (l + 1 != r) {
    mid = (l + r) >> 1;
    if (root[mid].ask(a, 0, n) < b) {
      l = mid;
    } else {
      r = mid;
    }
  }
  return r;
}
int a[200005], b[200005];
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; ++i) {
    scanf("%d", &a[i]);
    b[a[i]] = i;
    root[i] = root[i - 1];
    root[i].add(a[i], i, 0, n);
  }
  long long sum = 0;
  for (int i = 1; i <= n; ++i) {
    int d = rf(i, (i >> 1) + (i & 1));
    long long ans = 0;
    ans += root[d].asksum(n, 0, n) - root[d].asksum(i, 0, n);
    long long tmp = d - (i >> 1) - (i & 1);
    ans -= tmp * (tmp + 1) / 2;
    tmp = d + (i >> 1) + 1;
    ans += (n + tmp) * (n - tmp + 1) / 2;
    ans -= (root[n].asksum(n, 0, n) - root[n].asksum(i, 0, n)) -
           (root[d].asksum(n, 0, n) - root[d].asksum(i, 0, n));
    sum += i - root[b[i]].ask(i, 0, n);
    ans += sum;
    printf("%lld ", ans);
  }
}
