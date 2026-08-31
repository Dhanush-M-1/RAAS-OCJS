//dp発想
#include <iostream>
using namespace std;
const int mo = 1e9 + 7;
int main()
{
    int m,n,f[100010];
    cin >> n >> m;
    bool a[100010];
    for( int i = 0, x; i < m; i++ )
    {
        cin >> x; a[x] = 1;
    }
    f[0] = 1;
    for( int i = 1; i <= n; i++ )
    {
        f[i] = ( f[i - 1] + f[i - 2] ) % mo;
        if( a[i] ) f[i] = 0;
    }
    cout << f[n] << endl;
    return 0;
}