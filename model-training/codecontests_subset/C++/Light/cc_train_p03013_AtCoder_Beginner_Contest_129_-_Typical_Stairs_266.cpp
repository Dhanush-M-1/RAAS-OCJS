#include <bits/stdc++.h>
using namespace std;

int main()
{
    int N, M, T;
    cin >> N >> M;
    vector<int> A(N, -1);
    A[0] = 1, A[1] = 2;
    while(M--)
    {
        cin >> T;
        A[T-1] = 0;
    }
    if(A[0] == 0 && A[1] != 0) A[1] = 1;
    for(int i = 2; i < N; i++)
    {
        if(A[i] != 0)
            A[i] = (A[i-1] + A[i-2]) % 1000000007;
    }
    cout << A[N-1] << endl;
}   