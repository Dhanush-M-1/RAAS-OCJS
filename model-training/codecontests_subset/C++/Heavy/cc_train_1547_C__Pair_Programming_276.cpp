    #include<bits/stdc++.h>
    using namespace std;
    #include<algorithm>
#include <stdlib.h>
    #include <numeric>
    
bool is_prime(long long  n) {
    // Assumes that n is a positive natural number
    // We know 1 is not a prime number
    if (n == 1) {
        return false;
    }

    long long  i = 2;
    // This will loop from 2 to long long (sqrt(x))
    while (i*i <= n) {
        // Check if i divides x without leaving a remainder
        if (n % i == 0) {
            // This means that n has a factor in between 2 and sqrt(n)
            // So it is not a prime number
            return false;
        }
        i += 1;
    }
    // If we did not find any factor in the above loop,
    // then n is a prime number
    return true;
}





vector<long long> primeFactors(long long n)
{
    vector<long long> v;
    // Print the number of 2s that divide n
    while (n % 2 == 0)
    {
        v.push_back(2);
        // cout << 2 << " ";
        n = n/2;
    }
 
    // n must be odd at this point. So we can skip
    // one element (Note i = i +2)
    for (long long i = 3; i <= sqrt(n); i = i + 2)
    {
        // While i divides n, print i and divide n
        while (n % i == 0)
        {
            v.push_back(i);
            n = n/i;
        }
    }
 
    // This condition is to handle the case when n
    // is a prime number greater than 2
    if (n > 2)
        v.push_back(n);

    return v;
}
    // vector<pair<long long,long long >> v;
    // for (long long i = 0; i < n; ++i)
    // {
    //     long long  x ,y;
    //     cin>>x>>y;

    //     v.push_back(make_pair(x,y));
        
    // }

long long gcd(long long int a, long long int b)
{
  if (b == 0)
    return a;
  return gcd(b, a % b);
}
 
// Function to return LCM of two numbers
long long lcm(int a, int b)
{
    return (a / gcd(a, b)) * b;
}

bool isPower(long long  x, long long  y)
{
    // logarithm function to calculate value
    long long  res1 = log(y) / log(x);
    double res2 = log(y) / log(x); // Note : this is double
 
    // compare to the result1 or result2 both are equal
    return (res1 == res2);
}

// A function to perform division of large numbers
string longDivision(string number, int divisor)
{
    // As result can be very large store it in string
    string ans;
 
    // Find prefix of number that is larger
    // than divisor.
    int idx = 0;
    int temp = number[idx] - '0';
    while (temp < divisor)
        temp = temp * 10 + (number[++idx] - '0');
 
    // Repeatedly divide divisor with temp. After
    // every division, update temp to include one
    // more digit.
    while (number.size() > idx) {
        // Store result in answer i.e. temp / divisor
        ans += (temp / divisor) + '0';
 
        // Take next digit of number
        temp = (temp % divisor) * 10 + number[++idx] - '0';
    }
 
    // If divisor is greater than number
    if (ans.length() == 0)
        return "0";
 
    // else return ans
    return ans;
}






int main()
{
    int t ;
    cin>>t;
    while(t>0)
    {
        cin.ignore();
        int k,n,m;
        cin>>k>>n>>m;
        vector<int> mono(n);
        vector<int> poly(m);
        

        int zeroes = 0;
        for(int i =0;i<n;i++)
        {
            cin>>mono[i];
            if(mono[i]==0)
            {
                zeroes++;
            }
        }
        for(int i =0;i<m;i++)
        {
            cin>>poly[i];
            if(poly[i]==0)
            {
                zeroes++;
            }
        }
        vector<int> ans;
        // cout<<"zeroez "<<zeroes<<endl;

        bool flag = true;
        int i =0;
        int j =0;
        int count = 0;
        while(i<n && j<m)
        {
            if(mono[i]==0 )
            {
                ans.push_back(0);
                i++;
                count++;
            }
            if(poly[j]==0)
            {
                ans.push_back(0);
                j++;
                count++;
            }
            if(i<n && j<m)
            {
                if(mono[i]!=0 && poly[j]!=0)
                {
                    if(min(mono[i],poly[j])>(count+k))
                    {
                        flag = false;
                        break;
                    }
                    else
                    {
                        ans.push_back(min(mono[i],poly[j]));
                        if(poly[j]>mono[i])
                        {
                            i++;
                        }
                        else
                        {
                            j++;
                        }
                    }
                }
            }
        }
        while(i<n)
        {
            if(mono[i]==0)
            {
                ans.push_back(0);
                i++;
                count++;
            }
            else
            {
                if(count+k<mono[i])
                {
                    flag = false;
                    break;
                }
                else
                {
                    ans.push_back(mono[i]);
                    i++;
                }
            }
        }
        while(j<m)
        {
            if(poly[j]==0)
            {
                ans.push_back(0);
                j++;
                count++;
            }
            else
            {
                if(count+k<poly[j])
                {
                    flag = false;
                    break;
                }
                else
                {
                    ans.push_back(poly[j]);
                    j++;
                }
            }
        }



   
        
         if(flag==false)
         {
            cout<<-1<<endl;
         }
         else
         {
            for (int i = 0; i < ans.size(); ++i)
            {
                cout<<ans[i]<<" ";
            }
            cout<<endl;
         }
   

    





        t--;
    }

}
        
 
 
 
    
  
 
 
 
