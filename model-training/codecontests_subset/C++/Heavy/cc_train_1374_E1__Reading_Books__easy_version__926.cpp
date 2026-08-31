#include <bits/stdc++.h>
using namespace std;
void Ios() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  return;
}
constexpr int kN = int(2E5 + 10), kInf = int(2E9 + 10);
mt19937_64 rng;
struct Treap {
  struct Node {
    Node *l, *r;
    int val, sz, sum;
    long long int wei;
    Node() {}
    Node(int x) {
      l = r = nullptr;
      sz = 1;
      val = sum = x;
      wei = rng();
    }
    void pull() {
      sz = 1;
      sum = val;
      if (l) {
        sz += l->sz;
        sum += l->sum;
      }
      if (r) {
        sz += r->sz;
        sum += r->sum;
      }
      return;
    }
  };
  static int size(Node* u) { return u ? u->sz : 0; }
  static int sum(Node* u) { return u ? u->sum : 0; }
  static Node* Merge(Node* a, Node* b) {
    if (!a) return b;
    if (!b) return a;
    if (a->wei > b->wei) {
      a->r = Merge(a->r, b);
      a->pull();
      return a;
    } else {
      b->l = Merge(a, b->l);
      b->pull();
      return b;
    }
  }
  static void Split_by_size(Node* s, int x, Node*& a, Node*& b) {
    if (!s)
      a = b = nullptr;
    else if (size(s->l) + 1 <= x) {
      a = s;
      Split_by_size(s->r, x - (size(s->l) + 1), a->r, b);
      a->pull();
    } else {
      b = s;
      Split_by_size(s->l, x, a, b->l);
      b->pull();
    }
  }
  static void Split_by_val(Node* s, int x, Node*& a, Node*& b) {
    if (!s)
      a = b = nullptr;
    else if (s->val <= x) {
      a = s;
      Split_by_val(s->r, x, a->r, b);
      a->pull();
    } else {
      b = s;
      Split_by_val(s->l, x, a, b->l);
      b->pull();
    }
  }
  Node* rt;
  Treap() { rt = nullptr; }
  void add(int x) {
    Node *A, *B;
    Split_by_val(rt, x, A, B);
    rt = Merge(Merge(A, new Node(x)), B);
    return;
  }
  int size() { return size(rt); }
  int ask(int x) {
    int ans;
    Node *A, *B;
    Split_by_size(rt, x, A, B);
    ans = sum(A);
    rt = Merge(A, B);
    return ans;
  }
};
Treap treap;
int t[kN], a[kN], b[kN];
int main() {
  int n, m, k, ans = kInf, idab = -1;
  vector<pair<int, int>> A, B, AB, O, V;
  vector<int> the_set;
  scanf("%d%d%d", &n, &m, &k);
  for (int i = 1; i <= n; i++) scanf("%d%d%d", &t[i], &a[i], &b[i]);
  for (int i = 1; i <= n; i++) {
    if (a[i] && b[i])
      AB.push_back(make_pair(t[i], i));
    else if (a[i])
      A.push_back(make_pair(t[i], i));
    else if (b[i])
      B.push_back(make_pair(t[i], i));
    else
      O.push_back(make_pair(t[i], i));
  }
  int asz = int(A.size()), bsz = int(B.size()), absz = int(AB.size()),
      osz = int(O.size());
  AB.push_back(make_pair(0, 0)), A.push_back(make_pair(0, 0)),
      B.push_back(make_pair(0, 0)), O.push_back(make_pair(0, 0));
  sort(AB.begin(), AB.end());
  sort(A.begin(), A.end());
  sort(B.begin(), B.end());
  sort(O.begin(), O.end());
  for (int i = 1; i <= asz; i++) A[i].first += A[i - 1].first;
  for (int i = 1; i <= bsz; i++) B[i].first += B[i - 1].first;
  for (int i = 1; i <= absz; i++) AB[i].first += AB[i - 1].first;
  for (int i = 1; i <= osz; i++) O[i].first += O[i - 1].first;
  for (int i = 1; i <= osz; i++) treap.add(O[i].first - O[i - 1].first);
  for (int i = k + 1; i <= asz; i++) treap.add(A[i].first - A[i - 1].first);
  for (int i = k + 1; i <= bsz; i++) treap.add(B[i].first - B[i - 1].first);
  for (int ab = 0; ab <= absz; ab++) {
    if (asz + ab >= k && bsz + ab >= k &&
        ab + (max(k - ab, 0)) + (max(k - ab, 0)) <= m && n - (absz - ab) >= m) {
      int tmp = AB[ab].first + A[max(k - ab, 0)].first +
                B[max(k - ab, 0)].first +
                treap.ask(m - (ab + (max(k - ab, 0)) + (max(k - ab, 0))));
      if (tmp < ans) ans = tmp, idab = ab;
    }
    if (k - ab <= asz && k - ab >= 1)
      treap.add(A[k - ab].first - A[k - ab - 1].first);
    if (k - ab <= bsz && k - ab >= 1)
      treap.add(B[k - ab].first - B[k - ab - 1].first);
  }
  if (idab < 0) goto No;
  for (int i = 1; i <= osz; i++)
    V.push_back(make_pair(O[i].first - O[i - 1].first, O[i].second));
  for (int i = max(k - idab + 1, 1); i <= asz; i++)
    V.push_back(make_pair(A[i].first - A[i - 1].first, A[i].second));
  for (int i = max(k - idab + 1, 1); i <= bsz; i++)
    V.push_back(make_pair(B[i].first - B[i - 1].first, B[i].second));
  for (int i = 1; i <= idab; i++) the_set.push_back(AB[i].second);
  for (int i = 1; i <= k - idab; i++) the_set.push_back(A[i].second);
  for (int i = 1; i <= k - idab; i++) the_set.push_back(B[i].second);
  sort(V.begin(), V.end());
  for (int i = 0; i < m - idab - (max(0, k - idab)) - (max(0, k - idab)); i++)
    the_set.push_back(V[i].second);
  printf("%d\n%d", ans, the_set[0]);
  for (int i = 1; i < m; i++) printf(" %d", the_set[i]);
  printf("\n");
  return 0;
No:
  printf("-1\n");
}
