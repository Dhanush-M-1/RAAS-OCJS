#include <bits/stdc++.h>
using namespace std;
struct treap {
  treap* l = nullptr;
  treap* r = nullptr;
  long long int pos;
  long long int vel;
  long long int y;
  long long int sum;
  int ch;
  static long long int s(treap* A) {
    if (A == nullptr) return 0;
    return A->sum;
  }
  static int c(treap* A) {
    if (A == nullptr) return 0;
    return A->ch;
  }
  static void re(treap* A) {
    if (A == nullptr) return;
    A->sum = s(A->l) + s(A->r) + A->pos;
    A->ch = c(A->l) + c(A->r) + 1;
  }
  treap(long long int pos, long long int vel) {
    this->vel = vel;
    this->pos = pos;
    this->y = rand() % 1000000000;
    re(this);
  }
  static treap* merge(treap* A, treap* B) {
    if (A == nullptr) return B;
    if (B == nullptr) return A;
    if (A->y > B->y) {
      A->r = merge(A->r, B);
      re(A);
      return A;
    } else {
      B->l = merge(A, B->l);
      re(B);
      return B;
    }
  }
  static pair<treap*, treap*> split(treap* A, long long int x) {
    if (A == nullptr) return {nullptr, nullptr};
    if (A->vel <= x) {
      auto T1 = split(A->r, x);
      A->r = T1.first;
      re(A);
      return {A, T1.second};
    } else {
      auto T1 = split(A->l, x);
      A->l = T1.second;
      re(A);
      return {T1.first, A};
    }
  }
  static treap* insert(treap* A, long long int pos, long long int vel) {
    auto T1 = split(A, vel);
    auto T2 = merge(T1.first, new treap(pos, vel));
    return merge(T2, T1.second);
  }
  static void func(treap* A, long long int x, long long int& cnt,
                   long long int& sum) {
    auto T1 = split(A, x);
    cnt = c(T1.first);
    sum = s(T1.first);
    merge(T1.first, T1.second);
  }
};
const int le = 2 * 1e5;
struct point {
  long long int pos = 0;
  long long int vel = 0;
  point(int pos = 0, int vel = 0) {
    this->pos = pos;
    this->vel = vel;
  }
  bool operator<(const point& other) const { return this->pos < other.pos; }
};
point arr[le];
int main() {
  iostream::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  srand(time(0));
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> arr[i].pos;
  }
  for (int i = 0; i < n; i++) {
    cin >> arr[i].vel;
  }
  sort(arr, arr + n);
  long long int ans = 0;
  treap* cur = nullptr;
  for (int i = 0; i < n; i++) {
    long long int cnt, sum;
    treap::func(cur, arr[i].vel, cnt, sum);
    cur = treap::insert(cur, arr[i].pos, arr[i].vel);
    ans += cnt * arr[i].pos - sum;
  }
  cout << ans << '\n';
  ;
  return 0;
}
