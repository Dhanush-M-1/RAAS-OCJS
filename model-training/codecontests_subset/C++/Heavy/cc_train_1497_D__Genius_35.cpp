        #include <bits/stdc++.h>
        using namespace std;
        #define ll long long int
       
       vector<bool>prime;
       vector<ll>fact;
       void SieveOfEratosthenes()
       {
        ll tot=0;
            ll n = 10000001;
             prime= vector<bool>(10000002,true);
             fact = vector<ll>(10000002,1);
            for (ll p = 2; p * p <= n; p++)
            {
                if (prime[p] == true) 
                {
                    tot++;
                  fact[p]=p;
                    for (int i = p * p; i <= n; i += p)
                      {  
                        prime[i] = false;
                        fact[i]=p;     
                    } 


               }
            }
         cout<<tot<<endl;
        }
        void solve()
        {
            ll n;
            cin>>n;

            ll s[n],tag[n];
             for(ll i=0;i<n;i++)
            {
                cin>>tag[i];
            }
            for(ll i=0;i<n;i++)
            {
                cin>>s[i];
            }
            vector<ll>dp(n+1,0);
            ll ans = 0;
            for(ll j=1;j<n;j++)
            {
                for(ll i=j-1;i>=0;i--)
                {
                    if(tag[i]==tag[j])
                        continue;
                    ll sum=abs(s[i]-s[j]);
                    ll x = sum+dp[i];
                    ll y = sum+dp[j];
                    dp[j]=max(dp[j],x);
                    dp[i]=max(dp[i],y);
                  //  cout<<i<<" "<<j<<" "<<sum<<" "<<dp[i]<<" "<<dp[j]<<endl;
                    ans = max(ans,max(dp[j],dp[i]));
                }
            }
            cout<<ans<<endl;
        }

         
        int main() {
        ios_base::sync_with_stdio(false);
        cin.tie(NULL);
         
        int TESTS = 1;
         cin>>TESTS;
         //SieveOfEratosthenes();
         while(TESTS--){

              solve();
         
               }
         
            return 0;
        }
