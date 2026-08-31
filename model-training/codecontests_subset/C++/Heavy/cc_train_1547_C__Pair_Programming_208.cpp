#include<bits/stdc++.h>
using namespace std;

int main()
{
    int t,it;
    cin >> t;
    for(it = 1; it <= t; it++)
    {
        long long int n,m,i,j,k,l,s = 0,d,f = 0;
        cin >> k >> n >> m;
        long long int ara[1000],arr[1000],str[1000];
        for(i = 0; i < n; i++)
        {
            cin >> ara[i];
        }
        for(i = 0; i < m; i++)
        {
            cin >> arr[i];
        }
        s += k;
        for(i = 0,j = 0,l = 0; (i < n) && (j < m); l++)
        {
            //cout << ara[i] << " " << arr[j] << endl;
            if(ara[i] == 0)
            {
                s++;
                str[l] = ara[i];
                i++;
                //cout << i << " " << ara[i] << endl;
            }
            else if(arr[j] == 0)
            {
                s++;
                str[l] = arr[j];
                j++;
                //cout << j << " " << arr[j] << endl;
            }
            else
            {
                if((ara[i] < arr[j]) && (ara[i] <= s))
                {
                    str[l] = ara[i];
                    i++;
                }
                else if((arr[j] <= ara[i]) && (arr[j] <= s))
                {
                    str[l] = arr[j];
                    j++;
                }
                else
                {
                    f = 1;
                    break;
                }
            }
            //cout << str[l] << endl;
        }
        if(f == 1)
        {
            cout << "-1\n";
        }
        else
        {
            while(i < n)
            {
                if(ara[i] == 0)
                {
                    str[l] = ara[i];
                    s++;
                    i++;
                    l++;
                }
                else if(ara[i] <= s)
                {
                    str[l] = ara[i];
                    i++;
                    l++;
                }
                else
                {
                    f = 1;
                    break;
                }
            }
            while(j < m)
            {
                if(arr[j] == 0)
                {
                    str[l] = arr[j];
                    s++;
                    j++;
                    l++;
                }
                else if(arr[j] <= s)
                {
                    str[l] = arr[j];
                    j++;
                    l++;
                }
                else
                {
                    f = 1;
                    break;
                }
            }
            if(f == 0)
            {
                for(i = 0; i < l; i++)
                {
                    cout << str[i];
                    if(i < l-1)
                    {
                        cout << " ";
                    }
                    else
                    {
                        cout << "\n";
                    }
                }
            }
            else
            {
                cout << "-1\n";
            }
        }
    }
    return 0;
}

