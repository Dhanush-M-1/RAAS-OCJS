#include<iostream>
using namespace std;

int bubbleSort( int* a, int n )
{
    int cnt = 0;
    for( int i = 0; i < n; i++ )
        for( int j = 0; j < n - 1; j++ )
        {
            if( a[j] > a[j+1] )
            {
                int temp = a[j];
                a[j] = a[j+1];
                a[j+1] = temp;
                cnt++;
            }
        }
    return cnt;
}

int main()
{
    int n, a[100];

    while( cin >> n )
    {
        if( n == 0 )
            break;
        for( int i = 0; i < 100; i++ )
            a[i] = 0;
        for( int i = 0; i < n; i++ )
            cin >> a[i];
        cout << bubbleSort( a, n ) << endl;
    }
    return 0;
}
