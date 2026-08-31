#include <iostream>
#include <numeric>
#include <vector>
using namespace std;
using lint = long long int;
#define FOR(i, begin, end) for(int i=(begin),i##_end_=(end);i<i##_end_;i++)
#define IFOR(i, begin, end) for(int i=(end)-1,i##_begin_=(begin);i>=i##_begin_;i--)
#define REP(i, n) FOR(i,0,n)
#define IREP(i, n) IFOR(i,0,n)
template<typename T> void Min(T &m, const T q) { if (m > q) m = q; }


int N;
lint D;
vector<lint> A, B;

int main()
{
    cin >> N >> D;
    A.resize(N);
    lint as = 0;
    REP(i, N)
    {
        cin >> A[i];
        as += A[i];
    }
    B = A;
    REP(i, N - 1) Min(B[i + 1], B[i] + D);
    IREP(i, N - 1) Min(B[i], B[i + 1] + D);

    cout << as + accumulate(B.begin() + 1, B.begin() + N - 1, 0LL) + (N - 1) * D << endl;
}
