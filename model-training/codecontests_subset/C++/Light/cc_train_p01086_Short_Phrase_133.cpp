#include<iostream>
#include<string>
using namespace std;

int main()
{
    int n, a[5] = { 5, 7, 5, 7, 7 }, b[40];
    string s[40];

    while( cin >> n )
    {
        if( !n )
            break;

        for( int i = 0; i < n; i++ )
        {
            cin >> s[i];
            b[i] = s[i].size();
        }

        for( int i = 0; i < n; i++ )
        {
            int sum = 0, k = 0, j = i;
            while( a[k] >= sum && j < n )
            {
                sum += b[j];
                j++;
                if( sum == a[k] )
                {
                    k++;
                    sum = 0;
                }
            }
            if( k == 5 )
            {
                cout << i + 1 << endl;
                break;
            }
        }   
    }
    return 0;
}
