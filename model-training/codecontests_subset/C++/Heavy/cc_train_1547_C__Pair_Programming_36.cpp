#include<bits/stdc++.h>
using namespace std;
int main()
{
    int t;
    cin >> t;
    while(t--)
    {
        int k, n, m;
        cin >> k >> n >> m;

        int i, j, a[n], b[m];
        for(i=0; i<n; i++)
            cin >> a[i];
        for(i=0; i<m; i++)
            cin >> b[i];

        vector<int> ans;
        int flag;
        flag = 0;
        j=0;
        for(i=0; i<n; i++)
        {
            if(flag==2)
                break;
            if(a[i]==0)
            {
                k++;
                flag=0;
                ans.push_back(a[i]);
            }
            else if(a[i]<=k)
            {
                ans.push_back(a[i]);
                flag=0;
            }
            else
            {
                i--;
                flag+=1;
                if(flag==2)
                    break;
                for(j=j; j<m; j++)
                {
                    if(b[j]==0)
                    {
                        k++;
                        flag=0;
                        ans.push_back(b[j]);
                    }
                    else if(b[j]<=k)
                    {
                        ans.push_back(b[j]);
                        flag=0;
                    }
                    else
                    {
                        flag++;
                        break;
                    }
                }
            }
        }

        if(flag==2)
        {
            cout << "-1" << endl;
        }
        else
        {

            for(j=j; j<m; j++)
            {
                if(b[j]==0)
                {
                    k++;
                    flag=0;
                    ans.push_back(b[j]);
                }
                else if(b[j]<=k)
                {
                    ans.push_back(b[j]);
                    flag=0;
                }
                else
                {
                    flag=5;
                    break;
                }
            }

            if(flag==5)
                cout << "-1" << endl;
            else
            {
                for(i=0; i<n+m; i++)
                {
                    cout << ans[i] << " ";
                }
                cout <<endl;
            }
        }
    }
}
