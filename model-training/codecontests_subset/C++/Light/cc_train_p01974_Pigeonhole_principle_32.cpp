#include <iostream>
#include <cstdlib>

using namespace std;

void solve(int n, int *a)
{
    for(int i = 0; i < n; i++) {
        for (int j = i+1; j< n; j++) {
            if(abs(a[i]-a[j])%(n-1) == 0) {
                cout << a[i] << " " << a[j] << endl;
                return;
            }
        }
    }
    return;
}

int main()
{
    int N;
    int a[1000];
    cin >> N;
    for(int i = 0; i < N; i++) {
        cin >> a[i];
    }
    solve(N, a);

    return 0;
}
