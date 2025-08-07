#include <bits/stdc++.h>

using namespace std;

string ltrim(const string &);
string rtrim(const string &);
vector<string> split(const string &);

template <typename T>
void count_sort(T& arr)
{
    int max = *max_element(arr.begin(), arr.end());
    int min = *min_element(arr.begin(), arr.end());
    int range = max - min + 1;

    vector<int> count(range);
    vector<int> output(arr.size());

    for (size_t i = 0; i < arr.size(); i++)
        count[arr[i] - min]++;

    for (size_t i = 1; i < count.size(); i++)
        count[i] += count[i - 1];

    for (int i = arr.size() - 1; i >= 0; i--)
    {
        output[count[arr[i] - min] - 1] = arr[i];
        count[arr[i] - min]--;
    }

    arr.swap(output);
}

vector<int> countingSort(vector<int> arr)
{
    count_sort(arr);
    
    return arr;
}

