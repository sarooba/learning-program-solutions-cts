
import React from 'react';
import CohortDetails from './CohortDetails';

function App() {
  const cohorts = [
    {
      name: 'React Bootcamp',
      status: 'ongoing',
      startDate: '2025-06-01',
      endDate: '2025-08-01',
    },
    {
      name: 'Java Spring Batch',
      status: 'completed',
      startDate: '2025-01-15',
      endDate: '2025-04-15',
    }
  ];

  return (
    <div className="App">
      <h1>Cohort Dashboard</h1>
      {cohorts.map((cohort, index) => (
        <CohortDetails key={index} cohort={cohort} />
      ))}
    </div>
  );
}

export default App;
