#include <iostream>
#include <numeric>
#include <vector>
using namespace std;
using lint = long long int;
struct fast_ios { fast_ios(){ cin.tie(0); ios::sync_with_stdio(false); }; } fast_ios_;
#define FOR(i, begin, end) for(int i=(begin),i##_end_=(end);i<i##_end_;i++)
#define IFOR(i, begin, end) for(int i=(end)-1,i##_begin_=(begin);i>=i##_begin_;i--)
#define REP(i, n) FOR(i,0,n)
#define IREP(i, n) IFOR(i,0,n)
template<typename T> void Min(T &m, const T q) { if (m > q) m = q; }

int N;
lint D;
vector<lint> A;
int main()
{
    cin >> N >> D;
    A.resize(N);
    for (auto &v : A) cin >> v;
    lint res = accumulate(A.begin(), A.end(), 0LL);
    REP(i, N - 1) Min(A[i + 1], A[i] + D);
    IREP(i, N - 1) Min(A[i], A[i + 1] + D);
    cout << res + accumulate(A.begin(), A.end(), 0LL) - A[0] - A[N - 1] + (N - 1) * D << endl;
}
